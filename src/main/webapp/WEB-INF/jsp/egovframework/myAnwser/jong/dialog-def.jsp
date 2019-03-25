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
      "image": {
      	"imageUri" : "https://5dbf49c9.ngrok.io<c:out value="${resume.thumnail }"/>" 
      }
    },
    {
      "text": {
        "text": [
          " <c:out value="${resume.birthday }"/>생으로 <c:out value="${resume.gender eq 'm' ? '남' : '여' }"/>자 입니다."
        ]
      }
    },
    {
      "text": {
        "text": [
          " 주소는 <c:out value="${resume.address }"/>이고 연락처는 <c:out value="${resume.phone }"/> 입니다."
        ]
      }
    },
    {
      "text": {
        "text": [
          "이메일은 <c:out value="${resume.email }"/>입니다. 감사합니다."
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