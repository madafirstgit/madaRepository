import com.hht.service.BillService;
import com.hht.service.impl.BillServiceImpl;
import org.junit.Test;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

/**
 * Created by mada on 2016/11/24.
 */

public class BillDishServiceTest {
    @Inject
    private BillService tBillDishService = new BillServiceImpl();

    /*@Test
    public void testuuid() throws Exception {
        try {
            System.out.println("start");
            tBillDishService.uuidTest();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    @Test
    public void testuuid() {

        Map<String,String> data = new HashMap<>();
        data.put("username", "123");
        data.put("password", "123");

        Http.RequestBuilder request = new Http.RequestBuilder()
                .method("POST")
                .uri("/billService/testUUId").bodyForm(data);
//                .uri("/testSetOperator/upd").bodyForm(data);

        Result result = Helpers.route(fakeApplication(),request, 300000000L);
        System.out.println("123123123");
        System.out.println(result);
//        assertEquals(200, result.status());

    }

    public void test() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                System.out.println("asdfsdfaWill not work when we have dep to Guice plugin");
            }
        });
    }

//    @Test
//    public void t1() {
//        running(fakeApplication(), new Runnable() {
//            public void run() {
//                Result result = Helpers.routeAndCall(controllers.routes.ref.Application.index(),new Http.RequestBuilder());
////                Result result = callAction(controllers.routes.ref.Application.index());
////                Assert.assertEquals(OK, staticus(result));
//                System.out.println(Helpers.contentAsString(result));
//            }
//        });
//    }

//    @Test
//    public void authenticateFailure() {
//        Result result = callAction(
//                controllers.routes.ref.Application.authenticate(),
//                fakeRequest().withFormUrlEncodedBody(ImmutableMap.of(
//                        "email", "bob@example.com",
//                        "password", "badpassword"))
//        );
//        assertEquals(400, status(result));
//        assertNull(session(result).get("email"));
//    }



    public void authByLoginErrorForm() {

        Map<String,String> data = new HashMap<>();
        data.put("username", "123");
        data.put("password", "123");

        Http.RequestBuilder request = new Http.RequestBuilder()
                .method("POST")
                .uri("/webService/openDesk").bodyForm(data);

        Result result = Helpers.route(fakeApplication(),request, Helpers.DEFAULT_TIMEOUT);
        assertEquals(200, result.status());
    }



        @Test
        public void t1(){
            Result result = new HomeController().index();
        }

}
