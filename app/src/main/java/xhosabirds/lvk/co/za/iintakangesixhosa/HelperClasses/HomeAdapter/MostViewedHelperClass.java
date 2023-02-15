package xhosabirds.lvk.co.za.iintakangesixhosa.HelperClasses.HomeAdapter;

/**
 * Created by Luvuko-Dell on 2/14/2023.
 */

public class MostViewedHelperClass {

    int image;
    String title, description;

    public MostViewedHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
