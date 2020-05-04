package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.JsonBean;



/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JsonBean jsonBeanList[] = new JsonBean[2];
		//Javaオブジェクトに値をセット
        JsonBean jsonBean = new JsonBean();
        jsonBean.setId("1");
        jsonBean.setName("tanaka");
        JsonBean jsonBean2 = new JsonBean();
        jsonBean2.setId("2");
        jsonBean2.setName("yamada");
        jsonBeanList[0] = jsonBean;
        jsonBeanList[1] = jsonBean2;


        ObjectMapper mapper = new ObjectMapper();
        try {
            //JavaオブジェクトからJSONに変換

            String testJson = mapper.writeValueAsString(jsonBeanList);
;
            //JSONの出力
            response.getWriter().write(testJson);

            System.out.println(testJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
