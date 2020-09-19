package novi.spring.projectlocally.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import novi.spring.projectlocally.service.AppUserDetailsImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;
    private String username;
    @JsonIgnore
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "originalPoster")
    private List<LocationPost> locationPosts;


    public AppUser()
    {

    }

    public AppUser(String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public List<LocationPost> getLocationPosts() {
        return this.locationPosts;
    }

    public void setLocationPosts(List<LocationPost> locationPosts) {
        this.locationPosts = locationPosts;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }



    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }



    public void setUserName(String userName)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }



    public String getPassword()
    {
        return password;
    }

}
