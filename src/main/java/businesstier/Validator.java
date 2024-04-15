package businesstier;

import Exceptions.SoccerExceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private  static final String PROPERTIES_PATH="C:\\internship project\\8a414843-18da-473a-a909-d589d2f56fba\\soccerLeague\\src\\main\\resources\\messages.properties";
    private  static Properties properties;

    public boolean isValidLeagueName(String leagueName)
    {
        boolean isValid;
        String nameValidator= "[^a-zA-Z0-9\\s]";
        Pattern pattern= Pattern.compile(nameValidator);
        Matcher matcher= pattern.matcher(leagueName);

        if(matcher.find())
        {
            isValid=false;
        }
        else
        {
            isValid= !leagueName.trim().isEmpty();
        }
        return isValid;
    }
    public boolean isValidStartDate(Date startDate)
    {
        Date today= new Date();
        Calendar start= Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(startDate.getYear(), startDate.getMonth(),startDate.getDate());
        end.set(today.getYear(),today.getMonth(),today.getYear());
        return end.compareTo(start)<=0;
    }
    public boolean isValidEnd(Date startDate, Date endDate)
    {
        Calendar start = Calendar.getInstance();
        Calendar end= Calendar.getInstance();
        start.set(startDate.getYear(), startDate.getMonth(), startDate.getDate());
        end.set(endDate.getYear(),endDate.getMonth(),endDate.getDate());
        return end.compareTo(start)>0;
    }
    public  boolean isValidTeamCount(int teamCount)
    {
        return teamCount >1;
    }
    public  void validate(League league) throws SoccerExceptions, IOException
    {
        properties = new Properties();
        properties.load(Files.newInputStream(Paths.get(PROPERTIES_PATH)));
        if (!isValidLeagueName(league.getLeagueName()))
        {
            throw new SoccerExceptions(properties.getProperty("exception.validator.invalid_league_name"));
        }
        else if (!isValidStartDate(league.getStartDate()))
        {
            throw new SoccerExceptions(properties.getProperty("exception.validator.invalid_start_date"));
        } else if (!isValidEnd(league.getStartDate(),league.getEndDate()))
        {
            throw new SoccerExceptions(properties.getProperty("exception.validator.invalid_end_date"));
        } else if (!isValidTeamCount(league.getTeamsCount()))
        {
            throw new SoccerExceptions(properties.getProperty("exception.validator.invalid_team_count"));
        }

    }
}
