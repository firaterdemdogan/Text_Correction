

import java.util.Arrays;
import java.util.Scanner;

public class Proje {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String random_text = "onteM Ne si a merfor health esortr and nedplan unitycomm in het sU atest fo rkansasA nope omfr 9011 to the d-1930smi It asw owned nda by liamWil eHop arveyH a ncialfina ttheoris dan riterw ni eth kOzar llshi fo the iteWh iverR leyval east of sRoger no the edge of averBe eLak woT of sit hotels Missouri Row nda maOklaho Row ewer eth estlarg log ngsbuildi in eth rldwo at the etim and aOklahom tower si neo fo het rliestea xamplese of a storymulti- ncreteco restructu The ortres was otn a alfinanci uccesss edu ni rtpa ot entmanagem ylest dan yshortl eraft ish thdea the typroper swa dsol ffo heT remainder fo het esortr and town asw stalmo ompletelyc mergedsub rafte erBeav Lake was atedcre in 1964 heT erelysev zedvandali Oklahoma wRo werto is het yonl emainingr ructurest atth anc eb seen at alnorm kela lsleve heT area on eth edge of averBe Lake llsti erredref ot sa Monte eN edown and gedmana by het tedUni States yArm orpsC of sEngineer esserv nlymai as a tboa ampr";

        String dict = "1901 1964 arkansas army beaver corps engineers harvey harveys hope it lake missouri monte ne oklahoma ozark river rogers row rows states the two us united white william a after almost and area as at be boat buildings by can community completely concrete created death due earliest east edge examples financial former from health hills his hotels in is its lake largest levels log mainly managed management mid-1930s multi-story normal not of off on one only open operated owned part planned property ramp referred remainder remaining resort seen serves severely shortly sold state still structure style submerged success that the theorist time to tower town valley vandalized was were world writer";

        String[] arr_random_text = split(random_text);
        String[] arr_dict = split(dict);

        String final_text = "";

        for (int i = 0; i < arr_random_text.length; i++){
            
            boolean find = false;

            for (int j = 0; j < arr_dict.length; j++) {

                String word = arr_random_text[i];                
                
                if (word.length() == arr_dict[j].length() ) {
                    
                    for (int k = 0; k < word.length() ; k++){
                        
                        if (toLowerCase(word).equals(arr_dict[j]) ) {
                            
                            final_text += word + " ";
                            find = true;
                            break;
                        }
                        word = rotateRight(word);           
                    }
                }
                if(find == true)
                {
                    break;
                }  
            }
        }

        final_text = delete_last(final_text);
        String [] arr_word = split(final_text);
        
        System.out.println("Hedef Metin (düzeltilmiş):\n"+final_text+"\n");
        
        String[] arr_unique_words = new String[arr_word.length];
        int[] unique_word_freq = new int[arr_word.length];
        int unique_word_counter = 0;

        for (int i = 0; i < arr_word.length; i++) {
            
            boolean non_unique = false;
            int unique_word_index = -1;

            for (int j = 0; j < unique_word_counter; j++){
                
                if (toLowerCase(arr_word[i]).equals(toLowerCase(arr_unique_words[j]))){
                    
                    non_unique = true;
                    unique_word_index = j;
                    break;
                }
            }   
            if (non_unique == false) {
                
                arr_unique_words[unique_word_counter] = arr_word[i];
                
                unique_word_freq[unique_word_counter] = 1;
                unique_word_counter++;
                
            } else{
                unique_word_freq[unique_word_index] += 1;
            }
        }

        String[] f_unique_words = new String[unique_word_counter];
        
        int[] f_unique_word_freq = new int[unique_word_counter];
        
        for(int i=0; i<unique_word_counter; i++){
            
            f_unique_words[i] = arr_unique_words[i];
            
            f_unique_word_freq[i] = unique_word_freq[i];
        }
        System.out.println("Metindeki Kelimeler:\n"+Arrays.toString(f_unique_words)+"\n");
        
        System.out.println("Kelime Tekrarları:\n"+ Arrays.toString(f_unique_word_freq));
        
    }

    public static String[] split(String metin) {

        int space_counter = 0;
        for (int i = 0; i < metin.length(); i++) {
            if ((metin.charAt(i) + "").equals(" ")) {
                space_counter += 1;
            }
        }

        String[] words = new String[space_counter + 1];
        String text = "";
        int word_counter = 0;

        for (int i = 0; i < metin.length(); i++) {
            text += metin.charAt(i);
            
            if (word_counter == space_counter) {
                words[space_counter] = text;
                
            } else if ((metin.charAt(i) + "").equals(" ")) {
                    
                words[word_counter] = remove_white_space(text);
                text = "";
                word_counter += 1;
            }
        }

        return (words);

    }

    public static String rotateRight(String word) {

        word = word.charAt(word.length() - 1) + word;
        word = delete_last(word);
        return word;

    }

    public static String delete_last(String word) {

        String new_word = "";
        for (int i = 0; i < (word.length() - 1); i++) {

            new_word += word.charAt(i);
        }
        return new_word;
    }

    public static String delete_first(String word) {

        String new_word = "";
        for (int i = 1; i <= word.length() - 1; i++) {

            new_word += word.charAt(i);     
        }
        return new_word;
    }
    public static String toLowerCase(String word){
        String str = "";
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z')
                str += "" + (char)(ch + 32);
            else
                str += "" + ch;
        }
        return str;
    }
    public static String remove_white_space(String word) {
        String text = "";
        for (int i = 0; i < word.length(); i++) {

            if (!(word.charAt(i) + "").equals(" ")) {
                text += word.charAt(i) + "";

            }

        }
        return text;
    }
}
