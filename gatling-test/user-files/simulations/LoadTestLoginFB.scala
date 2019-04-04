import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoadTestLoginFB extends Simulation {

val baseUrl = "https://kumparan.com/auth-proxy/provider/facebook/authorize"
val httpProtocol = http
    .baseUrl(baseUrl)
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")

val header_0 = Map("content-type" -> "application/json", "Origin" -> "https://kumparan.com", "Referer" -> "https://kumparan.com")

val scn = scenario("Load Test Login FB")
    .exec(http("Load Test Login API FB Kumparan")
        .post("/")
        .headers(header_0)
        .body(RawFileBody("loginFB.txt"))
        .check(status.is(200))
    )

setUp(
  scn.inject(
    atOnceUsers(1),
    rampUsers(1) during (5),
    constantUsersPerSec(1) during (15)
  ).protocols(httpProtocol)
)
}
 