package novi.spring.projectlocally.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Blob;

//Entity is lichtgewicht domeinklasse met alleen getters en setters om de db te vullen iedere nieuwe "locationpost" is een rij in de tabel

@Entity
public class LocationPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String locatieInfo;

    private String locatieOmschrijving;

    @Column(columnDefinition = "TEXT")
    private String locatieFoto;
    private double lat;
    private double lng;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("locationPosts")
//    @JoinColumn(name = "original_poster_user_id", nullable = false)
    public AppUser originalPoster;

    public String getLocatieFoto() {return locatieFoto;}

    public void setLocatieFoto(String locatieFoto) {
        this.locatieFoto = locatieFoto;
    }

    public Long getPostId()
    {
        return postId;
    }

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    public String getLocatieInfo()
    {
        return locatieInfo;
    }

    public void setLocatieInfo(String locatieInfo)
    {
        this.locatieInfo = locatieInfo;
    }

    public String getLocatieOmschrijving() {return locatieOmschrijving;}

    public void setLocatieOmschrijving(String locatieOmschrijving) {
        this.locatieOmschrijving = locatieOmschrijving;
    }

    public double getLat()
    {
        return lat;
    }

    public void setLat(double lat)
    {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

}
