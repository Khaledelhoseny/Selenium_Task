package reader;

import com.google.gson.Gson;
import data.DataModel;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadDataFromJson {
    public DataModel readJsonFile() throws FileNotFoundException {
        //Reading json file
        FileReader fileReader = new FileReader("data/testData.json") ;
        //Where you will assign or medel the fileReader in ??
        return new Gson().fromJson(fileReader , DataModel.class );

    }
}
