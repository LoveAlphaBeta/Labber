<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>信息补全</title>
		<link rel="stylesheet" href="../assets/css/main.css" />
	</head>

	<body style="width: 75%;background:#212423;margin: auto;">
		<div id="main" style="text-align: center;style=" color: white; "">
			<form action="../InformationCompletion.lab" method="post">

				<table>
					<tr>
						<td colspan="4" style="text-align: center;">
							<h3>补全来访者信息</h3></td>
					</tr>
					<!--<tr>
								<td><label for="SFaceUrl">设置头像</label></td>
								<td>
									<a href="javascript:;" class="file">
										<input type="file" id="SFaceUrl" name="SFaceUrl" title="ä¸ä¼ " />ä¸ä¼ å¤´å</a>
								</td>
							</tr>-->
					<tr>
						<td><label for="vDocID">学号：</label></td>
						<td colspan="3"><input type="text" value="${DocID}" pattern="\d{8}" title="请填写8位学号" id="vDocID" name="vDocID" required="required" contenteditable="false" />
						</td>
					</tr>
					<tr>
						<td><label for="vName">姓名：</label></td>
						<td colspan="3"><input type="text" id="vName" name="vName" value="${vName}" required="required" /></td>
					</tr>
					<tr>
						<td><label for="vGender">性别：</label></td>
						<td colspan="3"><input type="radio" id="male" name="vGender" value="男" checked="checked" />
							<label for="male">男</label>
							<input type="radio" id="female" name="vGender" value="女">
							<label for="female">女</label></td>
					</tr>
					<!--<tr id="addContact" name="addContact">
						<td>
							<a href="#" id="addContact" onclick="addContactWays(this)" class="button alt">添加联系方式</a>
						</td>
					</tr>-->
					<!--<tr>
						<td><label for="vDept">学院：</label></td>
						<td colspan="3">
							<select id="vDept">
								<option value="选择学院" selected="selected">- 选择所属学院 -</option>
								<c:forEach var="departments" items="${departmentsList}">
									<option value="${departments.DId}">${departments.DName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>-->
					<tr>
						<td><label for="vMajor">专业：</label></td>
						<td >
							<select id="vMajor" name="vMajor">
								<option value="选择所属专业" selected="selected">- 选择所属专业 -</option>
								<c:forEach var="majors" items="${majorsList}">
									<option  value="${majors.MId}">${majors.MName}</option>
								</c:forEach>
							</select>
						</td>
						<td><label for="vCID">班级：</label></td>
						<td><input type="text" id="vCID" name="vCID" required="required" /></td>
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
			var contact_ways = "<tr id='ContactWay" + contactIndex + "'><td><label for='ContactWay'>联系方式" + contactIndex + "</label></td><td><input type='text' id='ContactType" + (contactIndex++) + "' name='ContactType'/></td><td><input type='text' id='ContactID' name='ContactID'/><td><a href='#' id='ContactWay' onclick='removeContactWays(this)' class='button alt small'>删除</a></td>></td></tr>;"
			$('#addContact').before(contact_ways);

		}

		function removeContactWays() {
			$(event.target).closest("tr").remove();
			contactIndex--;
		}
	</script>
	<script type="text/javascript" src="../assets/js/jquery-3.1.1.min.js"></script>

</html>