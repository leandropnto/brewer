var Brewer = Brewer || {};

Brewer.MascaraCpfCnpj = (function () {

    function MascaraCpfCnpj() {
        this.radioTipoPessoa = $('.js-radio-tipo-pessoa');
        this.labelCpfCnpj = $('[for=cpfcnpj]');
        this.inputCpfCnpf = $('#cpfcnpj');
    }

    MascaraCpfCnpj.prototype.iniciar = function () {
        this.radioTipoPessoa.on('change', onTipoPessoaAlterado.bind(this));
    }

    function onTipoPessoaAlterado(evento){
        var tipoPessoaSelecionada = $(evento.currentTarget);
        var documento = tipoPessoaSelecionada.data('documento');
        var mascara = tipoPessoaSelecionada.data('mascara');
        this.labelCpfCnpj.text(documento);
        this.inputCpfCnpf.mask(mascara);
        this.inputCpfCnpf.removeAttr('disabled');
        this.inputCpfCnpf.val('');

    }


    return MascaraCpfCnpj;
}());

$(function () {

    var mascaraCpfCnpj = new Brewer.MascaraCpfCnpj();
    mascaraCpfCnpj.iniciar();
});