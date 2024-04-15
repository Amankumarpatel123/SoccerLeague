package businesstier;

import java.util.Date;

public class League {
    private String leagueName;
    private Date startDate;
    private Date endDate;
    private int teamsCount;

    public String getLeagueName()
    {
        return leagueName;
    }
    public void setLeagueName(String leagueName)
    {
        this.leagueName=leagueName;
    }
    public Date getStartDate()
    {
        return startDate;
    }
    public void setStartDate(Date startDate)
    {
        this.startDate=startDate;
    }
    public Date getEndDate()
    {
        return endDate;
    }
    public void setEndDate(Date endDate)
    {
        this.endDate=endDate;
    }
    public int getTeamsCount()
    {
        return teamsCount;
    }
    public void setTeamsCount(int teamsCount)
    {
        this.teamsCount=teamsCount;
    }

    @Override
    public String toString() {
        return "League Details:\n" +
                "League Name: \n" + leagueName  +
                ",League Starting Date: \n" + startDate +
                ",League Ending Date: \n" + endDate +
                ",Number of Teams: \n" + teamsCount +"\n";
    }

}
