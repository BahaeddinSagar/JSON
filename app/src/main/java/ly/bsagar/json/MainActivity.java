package ly.bsagar.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String jsonString = "{\"Data\":[{\"ImageURL\":\"https://m.media-amazon.com/images/M/MV5BNjQ3NWNlNmQtMTE5ZS00MDdmLTlkZjUtZTBlM2UxMGFiMTU3XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_.jpg\",\"URL\":\"https://www.imdb.com/title/tt0241527/?ref_=ttls_li_tt\",\"description\":\"An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, his family and the terrible evil that haunts the magical world.\",\"name\":\"Harry Potter and the Philosopher's Stone\",\"year\":2001},{\"ImageURL\":\"https://m.media-amazon.com/images/M/MV5BMTcxODgwMDkxNV5BMl5BanBnXkFtZTYwMDk2MDg3._V1_UX182_CR0,0,182,268_AL_.jpg\",\"URL\":\"https://www.imdb.com/title/tt0295297/?ref_=ttls_li_tt\",\"description\":\"An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.\",\"name\":\"Harry Potter and the Chamber of Secrets\",\"year\":2002},{\"ImageURL\":\"https://m.media-amazon.com/images/M/MV5BMTY4NTIwODg0N15BMl5BanBnXkFtZTcwOTc0MjEzMw@@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"URL\":\"https://www.imdb.com/title/tt0304141/?ref_=ttls_li_tt\",\"description\":\"It's Harry's third year at Hogwarts; not only does he have a new Defense Against the Dark Arts  teacher, but there is also trouble brewing. Convicted murderer Sirius Black has escaped the Wizards' Prison and is coming after Harry.\",\"name\":\"Harry Potter and the Prisoner of Azkaban\",\"year\":2004},{\"ImageURL\":\"https://m.media-amazon.com/images/M/MV5BMTI1NDMyMjExOF5BMl5BanBnXkFtZTcwOTc4MjQzMQ@@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"URL\":\"https://www.imdb.com/title/tt0330373/?ref_=ttls_li_tt\",\"description\":\"A young wizard finds himself competing in a hazardous tournament between rival schools of magic, but he is distracted by recurring nightmares.\",\"name\":\"Harry Potter and the Goblet of Fire \",\"year\":2005},{\"ImageURL\":\"https://m.media-amazon.com/images/M/MV5BMTM0NTczMTUzOV5BMl5BanBnXkFtZTYwMzIxNTg3._V1_UX182_CR0,0,182,268_AL_.jpg\",\"URL\":\"https://www.imdb.com/title/tt0373889/?ref_=ttls_li_tt\",\"description\":\"With their warning about Lord Voldemort's return scoffed at, Harry and Dumbledore are targeted by the Wizard authorities as an authoritarian bureaucrat slowly seizes power at Hogwarts.\",\"name\":\"Harry Potter and the Order of the Phoenix\",\"year\":2007},{\"ImageURL\":\"https://m.media-amazon.com/images/M/MV5BNzU3NDg4NTAyNV5BMl5BanBnXkFtZTcwOTg2ODg1Mg@@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"URL\":\"https://www.imdb.com/title/tt0417741/?ref_=ttls_li_tt\",\"description\":\"As Harry Potter begins his sixth year at Hogwarts, he discovers an old book marked as the property of the Half - Blood Prince  and begins to learn more about Lord Voldemort's dark past.\",\"name\":\"Harry Potter and the Half-Blood Prince\",\"year\":2009},{\"ImageURL\":\"https://m.media-amazon.com/images/M/MV5BMTQ2OTE1Mjk0N15BMl5BanBnXkFtZTcwODE3MDAwNA@@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"URL\":\"https://www.imdb.com/title/tt0926084/?ref_=ttls_li_tt\",\"description\":\"As Harry, Ron and Hermione race against time and evil to destroy the Horcruxes, they uncover the existence of the three most powerful objects in the wizarding world: the Deathly Hallows.\",\"name\":\"Harry Potter and the Deathly Hallows: Part 1\",\"year\":2010},{\"ImageURL\":\"https://m.media-amazon.com/images/M/MV5BMjIyZGU4YzUtNDkzYi00ZDRhLTljYzctYTMxMDQ4M2E0Y2YxXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"URL\":\"https://www.imdb.com/title/tt1201607/?ref_=ttls_li_tt\",\"description\":\"Harry, Ron, and Hermione search for Voldemort's remaining Horcruxes in their effort to destroy the Dark Lord as the final battle rages on at Hogwarts.\",\"name\":\"Harry Potter and the Deathly Hallows: Part 2\",\"year\":2011}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            JSONObject firstjsonObject = new JSONObject(jsonString);
            JSONArray firstJsonArray = firstjsonObject.getJSONArray("Data");
            ArrayList<notmovie> notmovieArrayList = new ArrayList<>();
            for (int i=0 ; i < firstJsonArray.length() ; i++){
                JSONObject indexObject = firstJsonArray.getJSONObject(i);
                String name = indexObject.getString("name");
                String des = indexObject.getString("description");
                int year = indexObject.getInt("year");
                notmovie m = new notmovie(name,des,year);
                notmovieArrayList.add(m);
            }
            /////////////////////////////////////////////////////////////////////
            // arraylist is defined.

            // define list-item

            //define listview
            ListView listView = findViewById(R.id.l);
            //create arrayadapter for notmovie
            notmovieAdapter adapter = new notmovieAdapter(this,
                    R.layout.item_layout,notmovieArrayList);
            //listview.setadapter
            listView.setAdapter(adapter);
//            JSONObject index3Object = firstJsonArray.getJSONObject(3);
//            String movieName = index3Object.getString("name");
//            int movieYear = index3Object.getInt("year");
            Log.d("FIRST JSON", "onCreate: "+firstjsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "error jsonString parsing", Toast.LENGTH_SHORT).show();
        }
    }
}
