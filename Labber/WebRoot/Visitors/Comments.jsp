<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>来访者评价</title>
		<link rel="stylesheet" href="../assets/css/main.css" />
	</head>

	<body style="width: 75%;background:#212423;margin: auto;">
		<div id="main" style="text-align: center;style=" color:white; "">
			<form action="../comment.visit.lab" method="post">

				<table>
					<tr>
						<td colspan="4" style="text-align: center;">
							<h3>意见与建议</h3>
						</td>
					</tr>
					<td><label for="vDocID">证件号：</label></td>
					<td colspan="3"><input type="text" pattern="\d{8}" title="请写8位数字" id="vDocID" disabled="disabled" name="vDocID" value="${vDocID}" /></td>
					</tr>
					<tr>
						<td><label for="vName">姓名：</label></td>
						<td colspan="3"><input type="text" id="vName" name="vName" value="${vName}" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label for="vScore">请您对我们进行评价：</label></td>

						<c:choose>
							<c:when test="${vScore > -1}">
								<td colspan="3">0 <input type="range" min="0" max="100" step="5" value="${vScore}" id="vScore" name="vScore" required="required" /> 100
								</td>
							</c:when>
							<c:otherwise>
								<td colspan="3">0 <input type="range" min="0" max="100" step="5" value="60" id="vScore" name="vScore" required="required" /> 100
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<td><label for="vComment">意见与建议：</label></td>
						<td colspan="3">
							<textarea rows="3" cols="20" id="vComment" name="vComment" placeholder="我们将仔细听取您的意见和建议">${vComment}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" style="text-align: center;">
							<input type="submit" value="提交" /> 
							<input type="reset" value="重新填写" />
							<a href="#" onclick="javascript:{self.history.back();}" class="button"> 返回 </a>
						</td>
					</tr>

				</table>

			</form>
		</div>
	</body>
	<script type="text/javascript">
		var contactIndex = 0; // TODO set a available list to save the saved index, use js to access attributes
		function addContactWays(caller) {
			var contact_ways = "<tr id='ContactWay" + contactIndex + "'><td><label for='ContactWay'>联系方式" +
				contactIndex +
				"：</label></td><td><input type='text' id='ContactType" +
				(contactIndex++) +
				"' name='ContactType'/></td><td><input type='text' id='ContactID' name='ContactID'/><td><a href='#' id='ContactWay' onclick='removeContactWays(this)' class='button alt small'>删除联系方式</a></td>></td></tr>;"
			$('#addContact').before(contact_ways);
		}

		function removeContactWays() {
			$(event.target).closest("tr").remove();
			contactIndex--;
		}
	</script>
	<script type="text/javascript" src="../assets/js/jquery-3.1.1.min.js"></script>

</html>