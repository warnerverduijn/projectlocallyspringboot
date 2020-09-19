package novi.spring.projectlocally.controller;
import novi.spring.projectlocally.model.AppUser;
import novi.spring.projectlocally.model.LocationPost;
import novi.spring.projectlocally.repository.AppUserRepository;
import novi.spring.projectlocally.repository.LocationPostRepository;
import org.apache.catalina.webresources.FileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/test")
@RestController
public class LocationPostController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LocationPostRepository locationPostRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping(value = "/get-post")
    public List <LocationPost> getLocationPost () {
        List<LocationPost> locationPostList = locationPostRepository.findAll();
        return locationPostList;
    }


    @PostMapping(value = "/create-post")
    public LocationPost createLocationPost(@RequestBody LocationPost newLocationPost,
                                           Principal principal)
    {

        String name = principal.getName();

        Optional<AppUser> user = this.appUserRepository.findByUsername(name);

        if (user.isPresent())
        {
            newLocationPost.originalPoster = user.get();
        }
        return locationPostRepository.save(newLocationPost);
    }


//    @PostMapping(value = "/create-pic", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public void createLocationPhoto(Principal principal,
//                                    @RequestPart("locatieFoto") MultipartFile foto
//    ) {
//        String name = principal.getName();
//
//        Optional<AppUser> user = this.appUserRepository.findByUsername(name);
//
//
//
//        try {
////            Path path = Paths.get(context.getRealPath("uploads")+ File.separator + foto.getOriginalFilename());
////            Files.copy(foto.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//
//            String uploadsDir = "/uploads/";
//            String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
//            if(! new File(realPathtoUploads).exists())
//            {
//                new File(realPathtoUploads).mkdir();
//            }
//
//            String orgName = foto.getOriginalFilename();
//            String filePath = realPathtoUploads + orgName;
//            File dest = new File(filePath);
//            foto.transferTo(dest);
//
//            if (user.isPresent()) {
//                LocationPost locationPost = this.locationPostRepository.findTopByOriginalPosterOrderByPostIdDesc(user.get());
//                locationPost.setLocatieFoto(filePath);
//                locationPostRepository.save(locationPost);
//            }
////            newLocationPost.setLocatieFotoLocatie(copyLocation.toString());
//        } catch (Exception e) {
//            System.out.println(e.getMessage()) ;
//        }
//
//    }





}
