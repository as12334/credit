<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="row" id="devToolDiv">
    <div class="position-wrap clearfix">
        <h2><a class="navbar-minimalize" href="javascript:void(0)"><i class="icon iconfont">&#xe610;</i> </a></h2>
        <span>组件监控</span><span>/</span><span>缓存组件</span>
    </div>
    <div id="editable_wrapper" role="grid" class="col-lg-12 wrapper white-bg shadow dataTables_wrapper content-div">
        <div class="clearfix">
            <div class="col-lg-12">
                <div class="content line-hi34 clearfix">
                    <fieldset>
                        <legend>全局操作</legend>
                        <button target="refreshAllCache" type="button" class="_cacheBtn" >刷新所有数据缓存(字典|参数|国际化|动态列等)</button>
                        <button target="refreshI18nVersion" type="button" class="_cacheBtn" >刷新I18n_Version缓存</button>
                        <button target="refreshSiteVersion" type="button" class="_cacheBtn" >刷新Site_Version缓存</button>
                        <button target="refreshSiteNew" type="button" class="_cacheBtn" >刷新新站相关缓存</button>
                        <button target="checkSchemaMapping" type="button" class="_cacheBtn" >验证Mapper的完整性</button>
                    </fieldset>
                    <fieldset>
                        <legend>Page缓存</legend>
                        <lb:select name="sites" value="${access_domain.paramValue}" list="${sites}" listKey="id" listValue="id"/>
                        <button id="refreshSiteDomain" type="button">刷新站点Domain缓存</button>
                    </fieldset>
                    <fieldset>
                        <legend>缓存Key</legend>
                        <label>缓存通配符: </label><input type="text" size="60" value="" name="dataKey">
                        <button target="refreshDataCache" type="button" class="_cacheKeyBtn">刷新</button>
                        <button target="removeDataCache" type="button" class="_cacheKeyBtn">删除</button>
                        <button target="getDataCacheKeys" type="button" class="_cacheKeyBtn">查看Key</button>
                        <button target="getDataCache" type="button" class="_cacheKeyBtn">查看数据</button>
                        <button target="loadDataCache" type="button" class="_cacheKeyBtn">加载数据</button>
                        <button target="checkDomain" type="button" class="_cacheKeyBtn">查看Domain</button>

                        <c:forEach items="${rcVersionKeys}" var="version" varStatus="status">
                            <h3>RcVersion通配符: ${version.key}</h3>
                            <div class="clearfix">
                                <c:forEach items="${version.value}" var="p" varStatus="status">
                                    <li prefix="${version.key}" class="_cacheKey" style="margin-left:10px;float: left; width: 250px">${p}</li>
                                </c:forEach>
                            </div>
                        </c:forEach>
                        <c:forEach items="${dateKeys}" var="data" varStatus="status">
                            <h3>Data通配符: ${data.key}</h3>
                            <div class="clearfix">
                                <c:forEach items="${data.value}" var="p" varStatus="status">
                                    <li prefix="${data.key}" class="_cacheKey" style="margin-left:10px;float: left; width: 250px">${p}</li>
                                </c:forEach>
                            </div>
                        </c:forEach>
                    </fieldset>
                    <fieldset>
                        <legend>缓存结果</legend>
                        <textarea id="cacheResult" cols="120" rows="15"></textarea>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>
</div>

<soul:import res="site/devTool/Index"/>

