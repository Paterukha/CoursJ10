package ua.goit.java8.module82.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Taras on 16.09.2017.
 */

public class Images {
    private static final ArrayList<String> images = new ArrayList<>(50);

    static {
        images.add("http://www.technocrazed.com/wp-content/uploads/2017/08/9-FORESTS-THAT-WILL-MAKE-YOU-COMMUNE-WITH-NATURE-1-3.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2017/08/9-FORESTS-THAT-WILL-MAKE-YOU-COMMUNE-WITH-NATURE-1.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2017/08/9-FORESTS-THAT-WILL-MAKE-YOU-COMMUNE-WITH-NATURE-1-1-640x426.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2017/08/9-FORESTS-THAT-WILL-MAKE-YOU-COMMUNE-WITH-NATURE-1-4-640x427.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2017/08/9-FORESTS-THAT-WILL-MAKE-YOU-COMMUNE-WITH-NATURE-1-2-640x425.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-13.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-1-640x349.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-5-640x343.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-11-640x340.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-10-640x334.jpg");

        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-15-640x337.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-17-640x349.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-19-640x331.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-20-640x327.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-24-640x338.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-27-640x349.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-31-640x346.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-32-640x321.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/12/Iceland-unveils-its-haunting-landscapes-1-35-640x352.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2017/08/9-FORESTS-THAT-WILL-MAKE-YOU-COMMUNE-WITH-NATURE-1-5-640x427.jpg");

        images.add("http://www.technocrazed.com/wp-content/uploads/2017/08/9-FORESTS-THAT-WILL-MAKE-YOU-COMMUNE-WITH-NATURE-1-6-640x427.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2017/08/9-FORESTS-THAT-WILL-MAKE-YOU-COMMUNE-WITH-NATURE-1-7-640x427.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2017/08/9-FORESTS-THAT-WILL-MAKE-YOU-COMMUNE-WITH-NATURE-1-8-640x420.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268762-9518-CxPlT4QWEAATG-N.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268760-7797-CxSP-IrWQAATe6V-640x426.jpg");

        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268760-9323-CxRzq-DUoAAdY9u-640x426.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268760-7286-CxRzq-EVQAA7U-Z-640x427.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268761-6979-CxRzrJ1VIAE0jGO-640x427.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268760-3537-CxReo-XXcAAhOHz-640x418.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268761-1364-CxQdSxvXAAAtHc7-640x345.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268761-4427-CxQV9mdW8AAziMb-640x320.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268762-8844-CxQVRAyXUAAf6Ix-640x640.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268762-5725-CxQTXKtWEAAD4eM-640x426.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/11/1480268763-8819-CxPlT4PXEAQL2gv.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/08/The-5-Most-Magical-Spanish-Castles-1-2.jpg");

        images.add("http://www.technocrazed.com/wp-content/uploads/2016/08/The-5-Most-Magical-Spanish-Castles-1-640x516.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/08/The-5-Most-Magical-Spanish-Castles-1-3-640x398.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/08/The-5-Most-Magical-Spanish-Castles-1-4-640x354.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/08/The-5-Most-Magical-Spanish-Castles-1-1.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-5.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-640x400.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-1-640x452.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-4-640x495.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-2-640x427.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-3-640x391.jpg");

        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-7-640x452.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-8-640x476.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-9-640x427.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-12-640x427.jpg");
        images.add("http://www.technocrazed.com/wp-content/uploads/2016/05/15-Picturesque-Villages-That-Seem-Straight-Out-Of-A-Fairy-Tale-1-13-640x455.jpg");
    }

    public ArrayList<String> getImages(){
        return images;
    }

    // створення масиву рендомних лінків
    public ArrayList<String> getRandomImages(){
        Random random = new Random();
        ArrayList<String> result = new ArrayList<>(25);
        for (int i = 0; i < 25; i++){
            result.add(images.get(random.nextInt(images.size())));
        }
        return result;
    }
}
