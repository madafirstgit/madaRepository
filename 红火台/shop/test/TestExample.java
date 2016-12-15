import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

//import javaguide.tests.controllers.HomeController;

import java.util.ArrayList;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import play.twirl.api.Content;


public class TestExample  extends WithApplication {
    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder()
                .configure("play.http.router", "javaguide.tests.Routes")
                .build();
    }

//    @Test
//    public void testIndex() {
//        Result result = new HomeController().index();
//        assertEquals(OK, result.status());
//        assertEquals("text/html", result.contentType().get());
//        assertEquals("utf-8", result.charset().get());
//        assertTrue(contentAsString(result).contains("Welcome"));
//    }

    @Test
    public void testCallIndex() {
        Result result = route(
                fakeRequest("controllers.BillController.testUUID()", "/billService/testUUId")
        );
        assertEquals(OK, result.status());
    }
}







