package pk_Graphsqltest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Querysql_Querytest {
	@Test(priority=1)
	public void getAllFilmsTest()
	{
		RestAssured.baseURI = "https://swapi-graphql.netlify.app";
		String query = "{\"query\":\"{\\n  allFilms(first: 2) {\\n    films {\\n      created\\n      director\\n      title\\n    }\\n  }\\n}\"}";
		given().log().all()
			.contentType("application/json")
			.body(query)
			.when().log().all()
			.post("/.netlify/functions/index")
				.then().log().all()
					.assertThat()
						.statusCode(200)
							.and()
								.body("data.allFilms.films[0].director", equalTo("George Lucas"));
		
	}

}
