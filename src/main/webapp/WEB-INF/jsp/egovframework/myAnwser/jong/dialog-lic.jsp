<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
{
  "fulfillmentMessages": [
    {
      "text": {
        "text": [
          "<c:out value="${userName }"/> 님의 <c:out value="${resumeItem }"/> 입니다."
        ]
      }
    },
    <c:forEach items="${resume }" var="resume" varStatus="i">
    {
      "card": {
        "title": "자격증명: <c:out value="${resume.certificate }"/>",
        "subtitle": "<c:out value="${resume.achieveDay }"/>에 취득"
      }
    }
      <c:if test="${i.last ne true}">
      ,
      </c:if>
    </c:forEach>
  ],
  "outputContexts" : 
 <c:out  value="${outputContextsStr }" escapeXml="false"/>
}