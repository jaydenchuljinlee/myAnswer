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
        "title": "회사명: <c:out value="${resume.company }"/>",
        "subtitle": "<c:out value="${resume.joinDay }"/>부터 <c:out value="${resume.leaveDay }"/>까지 근무"
      }
    },
    {
      "quickReplies": {
        "quickReplies": [
          "<c:out value="${resume.company }"/>이 뭐야"
        ]
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