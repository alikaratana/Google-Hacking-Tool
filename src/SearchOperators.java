
public class SearchOperators {

    public String all_the_words(String url, String[] strings)
    {
        for (int i=0;i<strings.length;i++)
        {
                url+=strings[i]+"+";
        }

        return url;
    }

    public String exact_phrase(String url, String[] strings)
    {
        for (int i=0;i<strings.length;i++)
        {
                url+="%22"+strings[i]+"%22+";
        }

        return url;
    }

    public String any_of_words(String url, String[] strings)
    {

        for (int i=0;i<strings.length;i++)
        {
            if(i==0)
                url+=strings[i];
            else
                url+="+OR+"+strings[i];
        }

        return url;
    }

    public String non_of_words(String url, String[] strings)
    {

        for (int i=0;i<strings.length;i++)
        {
                url+="-"+strings[i]+"+";
        }

        return url;
    }

    public String range(String url, String num1, String num2)
    {
        url+="+"+num1+".."+num2;
        return url;
    }


}
