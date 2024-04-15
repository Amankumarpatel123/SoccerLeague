package org.example;

import Exceptions.SoccerExceptions;
import businesstier.League;
import persentationtier.LeagueTester;
import utility.Converter;

import java.text.ParseException;
import java.util.List;

public class Main{
    public static  void main(String[] args) throws ParseException {
        LeagueTester leagueTester= new LeagueTester();

        try {
            String message= leagueTester.addLeague("laLiga2024","17/04/2024","23/04/2024",5);
            System.out.println(message);
        } catch (SoccerExceptions e) {
           e.printStackTrace();
        }

        try {
            List<League> leagueDetail=leagueTester.getLeagueDetails("16/04/2024");
        } catch (SoccerExceptions e) {
            e.printStackTrace();
        }
    }
}