cartItems.html

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>장바구니</title>
    <!-- Include header fragment -->
    <%@include file="fragments/header.jsp" %>
</head>
<body>
<div class="container col-5" style="text-align:center">
    <!-- Include bodyHeader fragment -->
    <%@include file="fragments/bodyHeader.jsp" %>
    <H1>장바구니</H1>
    <br/>
    <form action="/cartItem/order" method="post">
        <table class="table">
            <thead>
            <tr class="table-secondary">
                <th class="col-1"></th>
                <th class="col-3">상품명</th>
                <th class="col-1">개수</th>
                <th class="col-3">가격</th>
                <th class="col-3">총 가격</th>
                <th class="col-3">date</th>
                <th class="col-1"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${items}" var="item">
                <!-- check box -->
                <tr>
                    <td>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="cartItemIds" value="${item.id}">
                        </div>
                    </td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.count}"/></td>
                    <td><!-- 상품 가격 -->
                        <c:out value="${item.price}"/>
                    </td>
                    <td><!-- 상품 총 가격 -->
                        <c:out value="${item.totalPrice}"/>
                    </td>
                    <td><c:out value="${item.date}"/></td>
                    <td>
                        <a href="javascript:cancel(${item.id})"
                           class="btn btn-outline-danger btn-sm">주문 취소</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>

        <!-- 주문하기 button -->
        <c:if test="${items.totalElements != 0}">
            <div class="d-grid gap-2">
                <button class="btn btn-outline-secondary" type="submit">주문하기</button>
            </div>
        </c:if>
    </form>

    <!-- Include footer fragment -->
    <%@include file="fragments/footer.jsp" %>
</div> <!-- /container -->
</div>
</body>
<script>
    function cancel(id) {
        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", "/cartItem/" + id + "/cancel");
        document.body.appendChild(form);
        form.submit();
    }
</script>
</html>

Please note that the code uses JSP-specific tags and syntax to achieve similar functionality to Thymeleaf in the original HTML template. 
  Make sure that you have the appropriate JSP tags, such as <c:forEach> and <c:if>, available in your project's configuration.



------------------------------------------------------------------------------------------------------------


  bodyHeader.html
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>프리마켓</title>
</head>
<body>
<div class="float-end"> <!-- 로그아웃하면 다시 로그인 페이지로 넘어가게 됨 -->
    <form action="/logout" method="post">
        <button type="submit" class="btn btn-outline-warning btn-sm">로그아웃</button>
    </form>
</div>
<div class="header" style="margin-top:10%; margin-bottom:3%">
    <a href="/" style="text-align:left"><h3 class="text-muted">프리마켓</h3></a>
</div>
</body>
</html>

------------------------------------------------------------------------------------------------------------

  footer

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello Shop V2</title>
</head>
<body>
<!-- Your page content here -->
</body>
<footer class="footer">
    <hr/>
    <div style="text-align:left">&copy; Hello Shop V2</div>
</footer>
</html>


------------------------------------------------------------------------------------------------------------

  header

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <script src="/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

    <link href="/css/jumbotron-narrow.css" rel="stylesheet">
    <title>Hello, world!</title>
</head>
<body>
<!-- Your page content here -->
</body>
</html>

------------------------------------------------------------------------------------------------------------

  createItemForm
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <script src="/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

    <link href="/css/jumbotron-narrow.css" rel="stylesheet">
    <title>물건 등록</title>
</head>
<body>
<div class="container col-5" style="text-align:center">

    <div class="header">
        <%@include file="fragments/header.jsp" %>
    </div>

    <h1>물건 등록</h1>
    <br/>
    <div class="accordion" id="accordionExample">
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingOne">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    # BOOK
                </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <form action="/items/new/book" method="post" enctype="multipart/form-data">

                        <input type="hidden" name="memberId" value="${form.memberId}" />

                        <!-- 이미지 넣기 -->
                        <label>상품 이미지 업로드</label>
                        <div class="form-floating mb-3">
                            <input type="file" class="form-control" id="imgFile1" name="files" multiple="multiple">
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" name="name" class="form-control" placeholder="이름을 입력하세요">
                            <label>상품명</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="number" name="price" class="form-control" placeholder="가격을 입력하세요">
                            <label>가격</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="number" name="stockQuantity" class="form-control" placeholder="수량을 입력하세요">
                            <label>수량</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" name="author" class="form-control" placeholder="아티스트를 입력하세요">
                            <label>아티스트</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" name="isbn" class="form-control" placeholder="기타 정보를 입력하세요">
                            <label>ETC</label>
                        </div>

                        <div class="d-grid gap-2">
                            <button class="btn btn-outline-secondary" type="submit">상품 등록</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingTwo">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    # CLOTH
                </button>
            </h2>
            <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                <div class="accordion-body">

                    <form action="/items/new/cloth" method="post" enctype="multipart/form-data">

                        <input type="hidden" name="memberId" value="${form.memberId}" />

                        <!-- 이미지 넣기 -->
                        <label>상품 이미지 업로드</label>
                        <div class="form-floating mb-3">
                            <input type="file" class="form-control" id="imgFile2" name="files" multiple="multiple">
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" name="name" class="form-control" placeholder="이름을 입력하세요">
                            <label>상품명</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="number" name="price" class="form-control" placeholder="가격을 입력하세요">
                            <label>가격</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="number" name="stockQuantity" class="form-control" placeholder="수량을 입력하세요">
                            <label>수량</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" name="brand" class="form-control" placeholder="브랜드를 입력하세요">
                            <label>브랜드</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" name="size" class="form-control" placeholder="사이즈를 입력하세요">
                            <label>사이즈</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" name="color" class="form-control" placeholder="색상을 입력하세요">
                            <label>색상</label>
                        </div>

                        <div class="d-grid gap-2">
                            <button class="btn btn-outline-secondary" type="submit">상품 등록</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

    <div class="footer">
        <%@include file="fragments/footer.jsp" %>
    </div>
</div> <!-- /container -->
</div>
</body>
</html>


------------------------------------------------------------------------------------------------------------

  itemCardList
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>상점</title>
    <%@include file="fragments/header.jsp" %>
</head>
<body>
<div class="container col-5" style="text-align:center">
    <%@include file="fragments/bodyHeader.jsp" %>
    <H1>상점</H1>
    <br/>

    <div>
        <div>
            <form action="/item/search" method="post" class="row g-3">
                <div class="form-floating mb-3 col-sm-5">
                    <input type="text" name="itemName" class="form-control" placeholder="상품명"/>
                    <label>상품명</label>
                </div>

                <div class="form-floating col-sm-5">
                    <select name="itemType" class="form-select" id="floatingSelect">
                        <option value=""> ALL </option>

                        <c:forEach var="type" items="${T(jpabook.jpashop.domain.item.ItemType).values()}">
                            <option value="${type}">${type}</option>
                        </c:forEach>
                    </select>
                    <label for="floatingSelect">상품 타입</label>
                </div>

                <button type="submit" class="btn btn-secondary mb-3 col-sm-2">검색</button>
            </form>
        </div>
        <hr/>


        <div style="height : 30em">
            <div class="row row-cols-1 row-cols-md-4 g-4">
                <c:forEach var="item" items="${items}">
                    <div class="col">
                        <a class="card" style="height : 12em" href="<c:url value='/item/info?id='+${item.id}"/>">
                            <span style="height:60%">
                                <img src="<c:url value='/images/'+${item.id}"/>"
                                     class="card-img-top">
                            </span>
                            <div class="card-body">
                                <p class="card-title">${item.name}</p>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>

        <br/>

        <div class="btn-group me-2" role="group" aria-label="First group">
            <a type="button" class="btn btn-outline-secondary"
               href="<c:url value='/items/(page='+${startPage}+')'/>"> << </a>
            <c:forEach var="page" items="${#numbers.sequence(startPage, endPage)}">
                <c:choose>
                    <c:when test="${page != nowPage}">
                        <a type="button" class="btn btn-outline-secondary"
                           href="<c:url value='/items/(page='+${page}+')'/>">${page}</a>
                    </c:when>
                    <c:otherwise>
                        <strong type="button" class="btn btn-outline-secondary"
                                style="color:red">${page}</strong>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <a type="button" class="btn btn-outline-secondary"
               href="<c:url value='/items/(page='+${endPage+1}+')'/>"> >> </a>
        </div>

        <%@include file="fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>


------------------------------------------------------------------------------------------------------------

  itemMoreInfo
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title><ITEM></ITEM> 물건 정보</title>
    <%@include file="fragments/header.jsp" %>
</head>
<body>
<div class="container col-5" style="text-align:center">
    <%@include file="fragments/bodyHeader.jsp" %>
    <H1><ITEM></ITEM> 물건 정보</H1>
    <br/>

    <span class="d-block p-2 text-bg-dark fs-2" style="text-align:left"><c:out value="${item.dtype}" /></span>
    <br/>

    <div class="container text-center">
        <form action="/order" method="post">
            <div class="row">
                <div class="col-6" style="display:flex">
                    <img src="<c:url value='/images/' + ${item.getId()} />">
                </div>

                <!-- 정보 -->
                <div class="col-6" style="text-align:left">
                    <b class="fs-5">상품 상세 정보</b>
                    <br/>
                    <br/>
                    <div class="row">
                        <div class="col-6">
                            <p>상품명</p>
                            <p>상품 가격</p>
                            <p>남은 수량</p>

                            <c:if test="${item.dtype == 'BOOK'}">
                                <p>저자</p>
                                <p>ISBN</p>
                            </c:if>

                            <c:if test="${item.dtype == 'CLOTH'}">
                                <p>브랜드</p>
                                <p>사이즈</p>
                                <p>색상</p>
                            </c:if>
                            <p>주문 수량</p>

                        </div>
                        <div class="col-6">
                            <p class="fw-bold"><c:out value="${item.name}" /></p>
                            <p class="fw-bold"><c:out value="${item.price}" /></p>
                            <p class="fw-bold"><c:out value="${item.stockQuantity}" /></p>

                            <c:if test="${item.dtype == 'BOOK'}">
                                <p class="fw-bold"><c:out value="${item.author}" /></p>
                                <p class="fw-bold"><c:out value="${item.isbn}" /></p>
                            </c:if>

                            <c:if test="${item.dtype == 'CLOTH'}">
                                <p class="fw-bold"><c:out value="${item.brand}" /></p>
                                <p class="fw-bold"><c:out value="${item.size}" /></p>
                                <p class="fw-bold"><c:out value="${item.color}" /></p>
                            </c:if>
                            <input type="hidden" name="itemId" id="itemId" class="form-control" value="<c:out value="${item.id}" />"/>
                            <div class="input-group input-group-sm mb-3">
                                <input type="number" name="count" id="count" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <br/>


            <div class="row">
                <div class="col-6 d-grid gap-2">
                    <button class="btn btn-outline-secondary" type="submit">주문하기</button>
                </div>
                <div class="col-6 d-grid gap-2">
                    <button class="btn btn-outline-secondary" type="submit" formaction="/addItem">장바구니에 담기</button>
                </div>
            </div>
        </form>

    </div>

    <%@include file="fragments/footer.jsp" %>
</div>
</body>
</html>



------------------------------------------------------------------------------------------------------------

  createMemberForm
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>회원 가입</title>
    <%@include file="fragments/header.jsp" %>
    <style>
        .fieldError {
            color: #bd2130;
        }
    </style>
</head>
<body>
<div class="row justify-content-center">
    <div class="container col-5" style="text-align:center">
        <%@include file="fragments/bodyHeader.jsp" %>
        <h1>회원 가입</h1>
        <br/>
        <form role="form" action="/members/new" method="post">

            <div class="form-floating mb-3">
                <input type="text" name="loginId" id="id" class="form-control"
                       placeholder="E-MAIL을 입력하세요"
                       value="<c:out value="${memberForm.loginId}" />"
                       class="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('loginId') ? 'form-control fieldError' : 'form-control'}">
                <p>
                    <c:if test="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('loginId')}">
                        <c:out value="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.getFieldError('loginId').getDefaultMessage()}" />
                    </c:if>
                </p>
                <label>이메일</label>
            </div>

            <!-- 비밀번호 -->
            <div class="form-floating mb-3">
                <input type="password" name="password" class="form-control"
                       placeholder="PASSWORD를 입력하세요"
                       class="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('password') ? 'form-control fieldError' : 'form-control'}">
                <p>
                    <c:if test="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('password')}">
                        <c:out value="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.getFieldError('password').getDefaultMessage()}" />
                    </c:if>
                </p>
                <label>비밀번호</label>
            </div>

            <!-- 비밀번호 확인 -->
            <div class="form-floating mb-3">
                <input type="password" name="passwordConfirm" class="form-control"
                       placeholder="PASSWORD를 입력하세요"
                       class="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('passwordConfirm') ? 'form-control fieldError' : 'form-control'}">
                <p>
                    <c:if test="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('passwordConfirm')}">
                        <c:out value="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.getFieldError('passwordConfirm').getDefaultMessage()}" />
                    </c:if>
                </p>
                <label>비밀번호 확인</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="username" class="form-control"
                       placeholder="이름을 입력하세요"
                       class="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('username') ? 'form-control fieldError' : 'form-control'}">
                <p>
                    <c:if test="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('username')}">
                        <c:out value="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.getFieldError('username').getDefaultMessage()}" />
                    </c:if>
                </p>
                <label>이름</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="city" class="form-control" placeholder="도시를 입력하세요">
                <label>도시</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="street" class="form-control" placeholder="거리를 입력하세요">
                <label>도로명</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="detail" class="form-control" placeholder="상세 정보를 입력하세요">
                <label>상세 정보</label>
            </div>

            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-outline-secondary">회원가입</button>
            </div>
        </form>

        <%@include file="fragments/footer.jsp" %>
    </div> <!-- /container -->
</div>
</body>
</html>


------------------------------------------------------------------------------------------------------------

  memberInfo
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>나의 개인정보</title>
    <%@include file="fragments/header.jsp" %>
    <style>
        .fieldError {
            border-color: #bd2130;
        }
    </style>
</head>
<body>
<div class="row justify-content-center">
    <div class="container col-5" style="text-align:center">
        <%@include file="fragments/bodyHeader.jsp" %>
        <h1>나의 개인정보</h1>
        <br/>

        <hr/>
        <form role="form" action="/member/edit" method="post">
            <div class="form-floating mb-3">
                <input type="text" name="loginId" class="form-control"
                       placeholder="E-MAIL을 입력하세요"
                       value="<c:out value="${memberForm.loginId}" />"
                       class="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('loginId') ? 'form-control fieldError' : 'form-control'}">
                <p>
                    <c:if test="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('loginId')}">
                        <c:out value="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.getFieldError('loginId').getDefaultMessage()}" />
                    </c:if>
                </p>
                <label>이메일</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="password" class="form-control"
                       placeholder="PASSWORD를 입력하세요"
                       class="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('password') ? 'form-control fieldError' : 'form-control'}">
                <p>
                    <c:if test="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('password')}">
                        <c:out value="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.getFieldError('password').getDefaultMessage()}" />
                    </c:if>
                </p>
                <label>비밀번호</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="username" class="form-control"
                       placeholder="이름을 입력하세요"
                       class="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('username') ? 'form-control fieldError' : 'form-control'}">
                <p>
                    <c:if test="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.hasFieldErrors('username')}">
                        <c:out value="${pageContext.findAttribute('org.springframework.validation.BindingResult.memberForm')?.getFieldError('username').getDefaultMessage()}" />
                    </c:if>
                </p>
                <label>Name</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="city" class="form-control" placeholder="도시를 입력하세요">
                <label>City</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="street" class="form-control" placeholder="거리를 입력하세요">
                <label>Street</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="detail" class="form-control" placeholder="상세 정보를 입력하세요">
                <label>상세 정보</label>
            </div>

            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-outline-secondary">수정하기</button>
            </div>
        </form>

        <%@include file="fragments/footer.jsp" %>
    </div> <!-- /container -->
</div>
</body>
</html>



------------------------------------------------------------------------------------------------------------

  memberList
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>MEMBER LIST</title>
    <%@include file="fragments/header.jsp" %>
</head>
<body>
<div class="container  col-5" style="text-align:center">
    <%@include file="fragments/bodyHeader.jsp" %>
    <H1>MEMBER LIST</H1>
    <br/>

    <table class="table">
        <thead>
        <tr class="table-secondary">
            <th class="col-3">이름</th>
            <th class="col-3">도시</th>
            <th class="col-3">주소</th>
            <th class="col-3">상세 주소</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${members}" var="member">
            <tr>
                <td><c:out value="${member.username}" /></td>
                <td><c:out value="${member.city}" /></td>
                <td><c:out value="${member.street}" /></td>
                <td><c:out value="${member.detail}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!--    <div class="btn-group me-2" role="group" aria-label="First group">-->
    <!--      <th:block th:each = "i : ${#numbers.sequence(1,members.totalPages)}">-->
    <!--        <a type="button" class="btn btn-outline-secondary" th:text="${i}" th:href="@{members(page=${i-1})}"></a>-->
    <!--      </th:block>-->
    <!--    </div>-->
    <%@include file="fragments/footer.jsp" %>
</div> <!-- /container -->

<%@include file="fragments/footer.jsp" %>
</body>
</html>



------------------------------------------------------------------------------------------------------------

  orderForm
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>주문하기</title>
    <%@include file="fragments/header.jsp" %>
</head>
<body>
<div class="container col-5" style="text-align:center">
    <%@include file="fragments/bodyHeader.jsp" %>
    <h1></h1>
    <br/>
    <form role="form" action="/order" method="post">

        <div class="form-floating mb-3">
            <select name="itemId" id="item" class="form-control">
                <option value=""></option>
                <c:forEach items="${items}" var="item">
                    <option value="${item.id}"><c:out value="${item.name}" /></option>
                </c:forEach>
            </select>
            <label for="item">상품명</label>
        </div>

        <div class="form-floating mb-3">
            <input type="number" name="count" class="form-control" id="count" placeholder="주문 수량을 입력하세요">
            <label for="count">주문 수량</label>
        </div>

        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-outline-secondary">주문하기</button>
        </div>
    </form>
    <br/>
    <%@include file="fragments/footer.jsp" %>
</div> <!-- /container -->
</div>
</body>
</html>



------------------------------------------------------------------------------------------------------------

  orderList

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>주문 리스트</title>
    <%@include file="fragments/header.jsp" %>
</head>
<body>
<div class="container col-5" style="text-align:center">
    <%@include file="fragments/bodyHeader.jsp" %>
    <H1>주문 리스트</H1>
    <br/>

    <div>
        <hr/>

        <table class="table">
            <thead>
            <tr class="table-secondary">
                <th>회원명</th>
                <th>상품 이름</th>
                <th>주문가격</th>
                <th>주문수량</th>
                <th>총 가격</th>
                <th>상태</th>
                <th>일시</th>
                <th></th>
            </tr>
            </thead>

            <tbody>
                <c:forEach var="order" items="${orders}">
                    <c:forEach var="orderItem" items="${order.orderItems}">
                        <tr>
                            <td><c:out value="${order.member.username}" /></td>
                            <td><c:out value="${orderItem.item.name}" /></td>
                            <td><c:out value="${orderItem.orderPrice}" /></td>
                            <td><c:out value="${orderItem.count}" /></td>
                            <td><c:out value="${orderItem.totalPrice}" /></td>
                            <td><c:out value="${order.status}" /></td>
                            <td><c:out value="${order.orderDate}" /></td>
                            <td>
<!--                                <a href="#" class="btn btn-outline-danger btn-sm">CC</a>-->
                            </td>
                        </tr>
                    </c:forEach>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%@include file="fragments/footer.jsp" />
</div> <!-- /container -->
</body>
</html>





변환된 JSP 코드에서 Thymeleaf 특정 속성을 JSP 태그와 표현식으로 대체했습니다. <c:forEach> JSTL 코어 태그를 사용하여 주문 리스트를 반복하고, 
  주문 항목들을 표시하는데 사용했습니다. 
  Thymeleaf 레이아웃 속성인 th:replace는 JSP include로 대체되어 헤더와 푸터 섹션을 포함시킵니다. 주의할 점은 빈 <h1> 태그가 있으며, 원하는 제목을 추가해야 합니다.


  JSP로 변환된 코드에서 Thymeleaf 특정 속성들을 JSP 태그와 표현식으로 대체하였습니다. 
  th:block 태그는 <c:forEach>로 대체되어 주문 리스트와 주문 항목들을 반복합니다. Thymeleaf 표현식인 ${order.member.username}과 ${orderItem.item.name}은 JSP EL 표현식으로 대체되어 
  <c:out> 태그를 사용하여 값을 출력합니다. 주문 취소 버튼에 대한 주석 블록은 유지되었지만 현재 <!-- -->로 주석 처리되어 있습니다.


  JSP로 변환된 코드에서 Thymeleaf 특정 속성들을 JSP 태그와 표현식으로 대체하였습니다. 동적 콘텐츠 렌더링 및 조건문 처리를 위해 JSTL 코어 태그 (<c:out>, <c:if>)를 사용하였습니다. 
  Thymeleaf의 레이아웃 속성 (layout:decorate, layout:fragment)은 JSP가 Thymeleaf와 같이 레이아웃 템플릿을 지원하지 않기 때문에 제거되었습니다. 
  대신 JSP include를 사용하여 헤더와 푸터 섹션을 포함시킬 수 있습니다. 
  또한, Thymeleaf의 에러 처리 (th:class, th:errors 등)는 유효성 검사 오류를 처리하기 위해 JSTL 코어 태그와 동등한 방식으로 대체되었습니다.

  JSP로 변환된 코드에서 Thymeleaf 특정 표현식은 JSP 태그와 표현식으로 대체되었습니다. 
  또한, Thymeleaf 속성 (th:replace, th:text, th:if 등)은 해당하는 JSP 속성으로 대체되었습니다. 
  더불어, 동적 콘텐츠 렌더링과 조건부 렌더링을 위해 JSTL 코어 태그 (<c:out>, <c:if>)가 사용되었습니다. 
  Thymeleaf 프래그먼트는 JSP include (<%@include file="fragments/header.jsp" %>, <%@include file="fragments/bodyHeader.jsp" %>, 
  <%@include file="fragments/footer.jsp" %>)로 대체되었습니다.
