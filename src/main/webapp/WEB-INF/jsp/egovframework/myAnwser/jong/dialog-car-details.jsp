<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
{
  "fulfillmentMessages": [
    {
      "text": {
        "text": [
          "<c:out value="${userName }"/> 님의 <c:out value="${resumeItem }"/> 중에서 <c:out value="${resumeDetails }"/> 입니다."
        ]
      }
    },
     {
      "text": {
        "text": [
        	"<c:out value="${resumeContent.department }"/> 부서에서 <c:out value="${resumeContent.position }"/>직책으로 <c:out value="${resumeContent.duty }"/>를 수행했습니다. "
        ]
      }
    },
     {
      "text": {
        "text": [
        	"<c:out value="${resumeContent.content }" escapeXml="false"/> "
        ]
      }
    }
  ],
  "outputContexts" : 
 <c:out  value="${outputContextsStr }" escapeXml="false"/>
}