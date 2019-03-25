<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
{
  "fulfillmentMessages": [
    {
      "text": {
        "text": [
          "<c:out value="${userName }"/> 님의 <c:out value="${resumeItem }"/> 입니다."
       		<c:forEach items="${resume }" var="resume">
       		,	"\n"
       		,	" <c:out value="${resume }"/>"
       		</c:forEach>
       
        ]
      }
    },
    {
      "card": {
        "title": "Title: this is a card title",
        "subtitle": "This is the body text of a card.  You can even use line  breaks and emoji! 💁",
        "imageUri": "https://developers.google.com/actions/images/badges/XPM_BADGING_GoogleAssistant_VER.png",
        "buttons": [
          {
            "text": "This is a button",
            "postback": "https://assistant.google.com/"
          }
        ]
      }
    },
    {
      "quickReplies": {
        "quickReplies": [
          "<c:out value="${userName }"/>씨 <c:out value="${resumeItem }"/> 보여줘",
          "Suggestion"
        ]
      }
    }
  ],
  "outputContexts" : 
 <c:out  value="${outputContextsStr }" escapeXml="false"/>
}