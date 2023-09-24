<template>
  <div>
    <h1>AUTOR: {{ AUTOR }}</h1>
    <p>OBRA: {{ OBRA }}</p>
    <p>ENDEREÇO: {{ ENDERECO }}</p>
    <p>DISTRITO: {{ DISTRITO }}</p>
    <p>MUNICIPIO: {{ MUNICIPIO }}</p>
    <p>ANO DO PROJETO: {{ ANO_DO_PROJ }}</p>
    <p>ANO DE CONSTRUÇÃO: {{ ANO_CONST || 'N/A' }}</p>
    <p>CONSTRUTORA: {{ CONSTRUTORA || 'N/A' }}</p>
    <p>CONDEPHAAT: {{ CONDEPHAAT || 'N/A' }}</p>
    <p>CONPRESP: {{ CONPRESP || 'N/A' }}</p>
    <p>IPHAN: {{ IPHAN || 'N/A' }}</p>
    <p>USO ORIGINAL: {{ USO_ORIGINAL }}</p>
    <p>CÓDIGO ORIGINAL: {{ CODIGO_ORIGINAL || 'N/A' }}</p>
    <p>USO ATUAL: {{ USO_ATUAL }}</p>
    <p>CÓDIGO ATUAL: {{ CODIGO_ATUAL || 'N/A' }}</p>
    <p>STATUS: {{ STATUS }}</p>
    <p>REFORMA: {{ REFORMA || 'N/A' }}</p>
    <p>LATITUDE: {{ LATITUDE }}</p>
    <p>LONGITUDE: {{ LONGITUDE }}</p>
    <p>REFERÊNCIAS: <a :href="REFERENCIAS">{{ REFERENCIAS }}</a></p>
  </div>
</template>

<script>
export default {
  data() {
    return {
    }
  },
  created() {
    this.obj = {
    "AUTOR": "Joaquim Manoel Guedes Sobrinho",
    "OBRA": "Igreja de Santa Maria Madalena 2",
    "ENDEREÇO": "Rua Girassol,795 - Vila Madalena, São Paulo - SP, Brasil",
    "DISTRITO": "",
    "MUNICÍPIO": "São Paulo",
    "ANO DO PROJ.": 1955,
    "ANO CONST.": null,
    "CONSTRUTORA": null,
    "CONDEPHAAT": null,
    "CONPRESP": null,
    "IPHAN": null,
    "USO ORIGINAL": "Religioso",
    "CÓDIGO ORIGINAL": null,
    "USO ATUAL": "Religioso",
    "CÓDIGO ATUAL": null,
    "STATUS": "Construído",
    "REFORMA": 2015,
    "LATITUDE ": "-23.55245200",
    "LONGITUDE": "-46.6913300000",
    "REFERENCIAS": "https://docs.google.com/document/d/19dg0OI_ajQ9K8wPM-bdX8LTbQgBeGQ0fa4FBBp83hSg/edit"
    }
    this.AUTOR = this.obj['AUTOR'];
    this.OBRA = this.obj['OBRA'];
    this.ENDEREÇO = this.obj['ENDEREÇO'];
    this.DISTRITO = this.obj['DISTRITO'];
    this.MUNICIPIO = this.obj['MUNICÍPIO'];
    this.ANO_DO_PROJ = this.obj['ANO DO PROJ'];
    this.ANO_CONST = this.obj['ANO CONST'];
    this.CONSTRUTORA = this.obj['CONSTRUTORA'];
    this.CONDEPHAAT = this.obj['CONDEPHAAT'];
    this.CONPRESP = this.obj['CONPRESP'];
    this.IPHAN = this.obj['IPHAN'];
    this.USO_ORIGINAL = this.obj['USO ORIGINAL'];
    this.CODIGO_ORIGINAL = this.obj['CÓDIGO ATUAL'];
    this.USO_ATUAL = this.obj['USO ATUAL'];
    this.CODIGO_ATUAL = this.obj['CODIGO ATUAL'];
    this.STATUS = this.obj['STATUS'];
    this.REFORMA = this.obj['REFORMA'];
    this.LATITUDE = this.obj['LATITUDE'];
    this.LONGITUDE = this.obj['LONGITUDE'];
    this.REFERENCIAS = this.obj['REFERENCIAS'];
  }
}
</script>

<style>
/* Add any CSS styling here */
</style>
