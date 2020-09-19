package novi.spring.projectlocally.model;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;


public class AppUserTest {

    @Test
    void settingLocationPostInfoShouldReturnInfo() {

        //arrange
        LocationPost locationPost = new LocationPost();

        //act
        locationPost.setLocatieInfo("Een mooie plek om te wandelen");

        //assert
        assertEquals("Een mooie plek om te wandelen", locationPost.getLocatieInfo());
    }


    @Test
    void settingLongitudeShouldReturnLongitude(){

        LocationPost locationPost = new LocationPost();

        locationPost.setLng(98.98398938);

        assertEquals(98.98398938, locationPost.getLng());

    }

    @Test
    void settingLatitudeShouldReturnLatitude(){

        LocationPost locationPost = new LocationPost();

        locationPost.setLat(834.2878278728728782);

        assertEquals(834.2878278728728782, locationPost.getLat());

    }



}
