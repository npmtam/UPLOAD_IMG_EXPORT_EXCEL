package commons;

import java.util.ArrayList;
import java.util.List;

public class ReadDataCSV {
    public List<String> parseCsvLine (String csvLine){
        List<String> result = new ArrayList<String>();
        if(csvLine != null){
            String[] splitData = csvLine.split(Constants.COMMA_DELIMITER);
            for(int i = 0; i < splitData.length; i++){
                result.add(splitData[i]);
            }
        }
        return result;
    }


}
