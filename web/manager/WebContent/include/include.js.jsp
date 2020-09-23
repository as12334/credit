<%@ page import="so.wwb.lotterybox.web.tools.SessionManagerCommon" %>
<%@ include file="include.base.js.jsp" %>
<script>
   var isTempDomain=<%=SessionManagerCommon.getSiteDomain(request).getIsTemp()%>;
</script>
<script type="text/javascript">
    curl(['lb/components/select'], function(Page) {
        select = new Page();
    });
    curl(['zeroClipboard','UE'], function (zeroClipboard,UE) {
       window.ZeroClipboard=zeroClipboard;
        window.UE=UE;
    });
</script>