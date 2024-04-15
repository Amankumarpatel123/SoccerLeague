package persentationtier;

import Exceptions.SoccerExceptions;
import businesstier.League;
import businesstier.LeagueManager;
import utility.Converter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Properties;

public class LeagueTester {
    private static  final String PROPERTIES_PATH="C:\\Users\\ASUS\\OneDrive\\Desktop\\soccerLeague\\src\\main\\resources\\messages.properties";

    private  static Properties properties= new Properties();
    private League league=new League();
    private Converter converter= new Converter();
    private LeagueManager leagueManager= new LeagueManager();

    public  String addLeague(String leagueName,String startDate, String endDate,int numberOfTeams) throws SoccerExceptions
    {
        league.setLeagueName(leagueName);
        try {
            properties.load(Files.newInputStream(Paths.get(PROPERTIES_PATH)));
            league.setStartDate(converter.stringToDate(startDate));
            league.setEndDate(converter.stringToDate(endDate));
        }catch (ParseException e){
            throw new SoccerExceptions(properties.getProperty("exception.league.tester.invalid_date"));
        }catch (IOException e)
        {
            throw  new SoccerExceptions(properties.getProperty("exception.input_output"));
        }
        league.setTeamsCount(numberOfTeams);
        try{
            return leagueManager.addLeague(new ArrayList<League>(){{add(league);}});
        }catch (IOException e)
        {
            throw  new SoccerExceptions(properties.getProperty("exception.input_output"));
        }
    }
    public List<League> getLeagueDetails(String date) throws SoccerExceptions{
        Date inputDate;
        List<League>leagues;
        try{
            inputDate= converter.stringToDate(date);
            leagues= leagueManager.getLeagueDetailsOnOrAfter(inputDate);
        } catch (ParseException e) {
             throw new SoccerExceptions(properties.getProperty("exception.league_tester.invalid_date"));
        }
        catch (IOException e){
            throw new SoccerExceptions(properties.getProperty("exception.input_output"));
        }
        if(leagues.isEmpty())
        {
            throw new SoccerExceptions(properties.getProperty("exception.league_manager.no_records_found"));
        }
        try{
            return leagueManager.getLeagueDetailsOnOrAfter(inputDate);
        }catch (IOException e)
        {
            throw new SoccerExceptions(properties.getProperty("exception.input_output"));
        }
    }
}

