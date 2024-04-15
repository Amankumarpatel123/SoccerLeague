package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {
    private SimpleDateFormat simpleDateFormat;

    public Date stringToDate(String date) throws ParseException{
        simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.parse(date);
    }
}
