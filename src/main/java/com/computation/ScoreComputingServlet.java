package com.computation;
import com.RandomNumberProvider;
import com.db.Dao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
@WebServlet("/Compute")
public class ScoreComputingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Connection con;
        PreparedStatement pre;
        String username = req.getParameter("username");
        int userGuess = Integer.parseInt(req.getParameter("userGuess"));
        String output ;
        int score ;
        int attemps ;
        Random rand = RandomNumberProvider.getRandomNumberObject();
        int RandomNumber = rand.nextInt(3);
        try {
            con = Dao.getCon();
            String Extractquery = "SELECT * FROM numberguessinggamecodecasatask1.users_and_scores where username=?";
            pre = con.prepareStatement(Extractquery);
            pre.setString(1,username);
            ResultSet rst = pre.executeQuery();
            RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
            if(rst.next()){
                int dbScore = rst.getInt("score");
                int dbattemps = rst.getInt("attemps");

                if(dbattemps<=0){

                    output = "You exhausted all your attemps" ;
                }
                else{
                    dbattemps = dbattemps-1;
                    String UpdateScore = "Update numberguessinggamecodecasatask1.users_and_scores set score=?,attemps=? where username=?";
                    pre = con.prepareStatement(UpdateScore);
                    pre.setString(3,username);
                    if(RandomNumber == userGuess){
                        dbScore = dbScore+1 ;
                        pre.setInt(1,dbScore);
                        output = "Correct Guess";
                    }else{
                        pre.setInt(1,dbScore);
                        output = "Wrong Guess" ;
                    }
                    pre.setInt(2,dbattemps);
                    pre.executeUpdate();

                }
                score = dbScore ;
                attemps = dbattemps ;

            }else{
                int newUserAttemps = 4 ;
                String insertQuery = "INSERT INTO `numberguessinggamecodecasatask1`.`users_and_scores` (`username`, `score`, `attemps`) VALUES (?, ?, ?)";
                pre = con.prepareStatement(insertQuery);
                pre.setString(1,username);
                pre.setInt(3,newUserAttemps);
                int newUserScore = 0 ;
                if(RandomNumber == userGuess){
                    output = "Correct Guess";
                    newUserScore = newUserScore+1 ;
                }
                else{
                    output = "Wrong Guess";
                }
                pre.setInt(2,newUserScore);
                pre.executeUpdate();
                score = newUserScore ;
                attemps = newUserAttemps ;
            }
            req.setAttribute("username",username);
            req.setAttribute("result" , output);
            req.setAttribute("score",score);
            req.setAttribute("attemps",attemps);
            dispatcher.forward(req, resp);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
