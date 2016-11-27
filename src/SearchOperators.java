/**
 * Created by ali on 27.11.2016.
 */
public class SearchOperators {

    public String all_the_words(String url, String[] strings)
    {
        url+="as_q=";
        for (int i=0;i<strings.length;i++)
        {
            if(i==strings.length-1)
            {
                url+=strings[i];
            }
            else
            url+=strings[i]+"+";
        }

        return url;
    }

    public String exact_phrase(String url, String[] strings)
    {
        url+="as_epq=";
        for (int i=0;i<strings.length;i++)
        {
            if(i==strings.length-1)
            {
                url+=strings[i];
            }
            else
                url+=strings[i]+"+";
        }

        return url;
    }

    public String any_of_words(String url, String[] strings)
    {
        url+="as_oq=";
        for (int i=0;i<strings.length;i++)
        {
            if(i==strings.length-1)
            {
                url+=strings[i];
            }
            else
                url+=strings[i]+"+";
        }

        return url;
    }

    public String non_of_words(String url, String[] strings)
    {
        url+="as_eq=";
        for (int i=0;i<strings.length;i++)
        {
            if(i==strings.length-1)
            {
                url+=strings[i];
            }
            else
                url+=strings[i]+"+";
        }

        return url;
    }
}
