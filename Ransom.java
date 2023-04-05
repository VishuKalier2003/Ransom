/* Given two arrays ransomNote and magzine... Check if the ransomNote can be constructed from the magzine using a letter only once...
 * Eg 1: ransomNote = "a"      magzine = "b"                    Ans = false
 * Eg 2: ransomNote = "aa"     magzine = "ab"                   Ans = false
 * Eg 3: ransomNote = "aa"     magzine = "aab"                  Ans = true
 */

import java.util.*;
public class Ransom
{
    public boolean CheckConditions(String ransomNote, String magzine)
    {
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();     // Hashmap for Ransom Note...
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();   // Hashmap for Magzine Note...
        for(int i = 0; i < ransomNote.length(); i++)  // Loop for the Ransom note...
        {
            if(map1.containsKey(ransomNote.charAt(i)))    // If the Key is present...
                map1.replace(ransomNote.charAt(i), map1.get(ransomNote.charAt(i)), map1.get(ransomNote.charAt(i)) + 1);
            else      // If the key is not present...
                map1.put(ransomNote.charAt(i), 1);
        }
        for(int i = 0; i < magzine.length(); i++)     // Loop for the magzine...
        {
            if(map2.containsKey(magzine.charAt(i)))     // If the key is present...
                map2.replace(magzine.charAt(i), map2.get(magzine.charAt(i)), map2.get(magzine.charAt(i)) + 1);
            else         // If the key is not present...
                map2.put(magzine.charAt(i), 1);
        }
        System.out.println("The Ransom Note Map : "+map1);
        System.out.println("The Magzine Note Map : "+map2);
        for(Map.Entry<Character, Integer> set : map1.entrySet())
        {
            if(map2.containsKey(set.getKey()))     // If the Magzine and Ransom Note have the character...
            {
                if(map2.get(set.getKey()) < set.getValue())    // If the occurrences in Ransom is higher...
                    return false;
            }
            else
                return false;
        }
        return true;      // Return statement...
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String rans = "", note = "";
        System.out.print("Enter the ransom note : ");
        rans = sc.nextLine();
        System.out.print("Enter the context : ");
        note = sc.nextLine();
        Ransom ransom = new Ransom();      // Object creation...
        boolean find = ransom.CheckConditions(rans, note);     // Function Call...
        System.out.println("The Condition is : "+find);
        sc.close();
    }
}

// Time Complexity - O(n + m) time...
// Space Complexity - O(1) space...