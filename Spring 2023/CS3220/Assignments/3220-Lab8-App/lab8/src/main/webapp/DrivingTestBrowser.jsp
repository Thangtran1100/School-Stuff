<%@page import="java.util.List" %>
    <%@page import="model.Question" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Driving Test Question</title>

            </head>

            <body>
                <% List<Question> questionList = (List<Question>)getServletContext().getAttribute("questionEntry");
                
                        int idSession = 0;
                        
                        if (request.getAttribute("idSession") != null)
                        {
                        	idSession = Integer.parseInt(request.getAttribute("idSession").toString()) % questionList.size();
                        }%>
                        
                        <p>
                            <%=questionList.get(idSession).getDescription()%>
                        </p>

                        <p>
                        	1: <%=questionList.get(idSession).getAnswerA()%>
                        </p>

                        <p>
                        	2: <%=questionList.get(idSession).getAnswerB()%>
                        </p>

                        <p>
                        	3: <%=questionList.get(idSession).getAnswerC()%>
                        </p>

                        <p>
                        	Correct Answer: <%=questionList.get(idSession).getCorrectAnswer()%>
                        </p>

                        <p>
                        	<a href="DrivingTestBrowser?idSession=<%=++idSession%>">Next</a>
                        </p>

            </body>

            </html>