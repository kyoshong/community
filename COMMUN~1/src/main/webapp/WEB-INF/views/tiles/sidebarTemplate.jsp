<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="sidebar">
  <div class="user-profile">
    <div class="display-avatar animated-avatar">
    
      <img class="profile-img img-lg rounded-circle" 
      src="${pageContext.request.contextPath}/resources/assets/images/profile/male/image_1.png"
       alt="profile image">
    </div>
    <div class="info-wrapper">
      <p class="user-name">정민이</p>
      <h6 class="display-income">내정보</h6>
    </div>
  </div>
  <ul class="navigation-menu">
    <li class="nav-category-divider">MAIN</li>
    <li>
      <a href="index.jsp">
        <span class="link-title">Dashboard</span>
        <i class="mdi mdi-gauge link-icon"></i>
      </a>
    </li>
    <li>
      <a href="#sample-pages" data-toggle="collapse" aria-expanded="false">
        <span class="link-title">Sample Pages</span>
        <i class="mdi mdi-flask link-icon"></i>
      </a>
      <ul class="collapse navigation-submenu" id="sample-pages">
        <li>
          <a href="login_1" target="_blank">Login</a>
        </li>
        <li>
          <a href="pages/sample-pages/error_2.html" target="_blank">Error</a>
        </li>
      </ul>
    </li>
    <li>
      <a href="#ui-elements" data-toggle="collapse" aria-expanded="false">
        <span class="link-title">UI Elements</span>
        <i class="mdi mdi-bullseye link-icon"></i>
      </a>
      <ul class="collapse navigation-submenu" id="ui-elements">
        <li>
          <a href="pages/ui-components/buttons.html">Buttons</a>
        </li>
        <li>
          <a href="pages/ui-components/tables.html">Tables</a>
        </li>
        <li>
          <a href="pages/ui-components/typography.html">Typography</a>
        </li>
      </ul>
    </li>
    <li>
      <a href="pages/forms/form-elements.html">
        <span class="link-title">Forms</span>
        <i class="mdi mdi-clipboard-outline link-icon"></i>
      </a>
    </li>
    <li>
      <a href="pages/charts/chartjs.html">
        <span class="link-title">Charts</span>
        <i class="mdi mdi-chart-donut link-icon"></i>
      </a>
    </li>
    <li>
      <a href="pages/icons/material-icons.html">
        <span class="link-title">Icons</span>
        <i class="mdi mdi-flower-tulip-outline link-icon"></i>
      </a>
    </li>
    <li class="nav-category-divider">DOCS</li>
    <li>
      <a href="docs/docs.html">
        <span class="link-title">Documentation</span>
        <i class="mdi mdi-asterisk link-icon"></i>
      </a>
    </li>
  </ul>
  <div class="sidebar-upgrade-banner">
    <p class="text-gray">Upgrade to <b class="text-primary">PRO</b> for more exciting features</p>
    <a class="btn upgrade-btn" target="_blank" href="http://www.uxcandy.co/product/label-pro-admin-template/">Upgrade to PRO</a>
  </div>
</div>