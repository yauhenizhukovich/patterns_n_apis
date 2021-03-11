<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade create-nsi-entry-modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content create-nsi-entry-modal-content">
            <div class="modal-header create-nsi-entry-modal-header">
                <h5 class="modal-title">Создать запись в справочнике</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="create-nsi-entry-modal-close-cross">&times;</span>
                </button>
            </div>
            <div class="modal-body justify-content-center">
                <div class="row">
                    <div class="col-12">
                        <jsp:include page="form/create-form.jsp"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
