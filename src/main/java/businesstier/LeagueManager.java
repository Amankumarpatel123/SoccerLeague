package businesstier;

import Exceptions.SoccerExceptions;
import persistencetier.LeagueService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeagueManager {
    private final Validator validator= new Validator();
    private final LeagueService leagueService= new LeagueService();
    
    public String addLeague(List<League> leagueList) throws SoccerExceptions, IOException{
        for (League league : leagueList)
        {
            validator.validate(league);
        }
        for (League league:leagueList)
        {
            leagueService.addLeague(league);
        }
        return "League added Successfully!";

    }
    public List<League> getLeagueDetailsOnOrAfter(Date date) throws  IOException {
        List<League> leagueBeforeDate = new ArrayList<>();
        List<League> leagues = leagueService.getLeaguesDetails();
        for (League league : leagues) {
            if (date.compareTo(league.getStartDate()) <= 0) {
                leagueBeforeDate.add(league);
            }
        }
        return leagueBeforeDate;
    }
}
