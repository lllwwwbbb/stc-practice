
import java.util.ArrayList;

public class quchong {

    static ArrayList<Character> compare(String chararray, int start1,int start2)
    {
        ArrayList<Character> res = new ArrayList<Character>();
        int len = 0;
        for(int i = start1,j = start2;i<chararray.length()&&j<chararray.length();i++,j++)
        {
            if(chararray.toCharArray()[i] != chararray.toCharArray()[j])
                return res;
            res.add(chararray.toCharArray()[i]);
            len++;
        }
        return res;
    }
    public static void main(String[] args)
    {
        String input = "刚才我说了我要退款我要退款我要退款我都说了我要退款";
        ArrayList<Character> maxarray = new ArrayList<>();
        for(int i = 0;i<input.length();i++)
        {
            for (int j = 0;j<input.length();j++)
            {
                ArrayList<Character> temp = compare(input,i,j);
                if(temp.size() > maxarray.size())
                {
                    maxarray = temp;
                }
            }
        }
        String maxsub = maxarray.toArray().toString();
        String[] t = input.split(maxsub);
        String res = new String();
        for(int i = 0;i<t.length;i++)
        {
            res +=t[i];
        }
        System.out.println(res);
    }
}


