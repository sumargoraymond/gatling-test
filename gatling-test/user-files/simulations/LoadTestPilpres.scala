import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoadTestPilpres extends Simulation {

val baseUrl = "https://graphql-v4.kumparan.com"
val httpProtocol = http
    .baseUrl(baseUrl)
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

val header_0 = Map("Content-Type" -> "text/plain", "Origin" -> "https://kumparan.com", "Referer" -> "https://kumparan.com/pilpres")

val scn = scenario("Load Test Pilpres")
    .exec(http("Post GraphQL Pilpres")
        .post("/query")
        .headers(header_0)
        .body(RawFileBody("pilpresquery.txt"))
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
 