<template>
  <div id="app">
    <h1>Latitude: {{ lat }}</h1>
    <h1>Longitude: {{ lon }}</h1>
  </div>
</template>

<script>
export default {
  data() {
    return {
      lat: null,
      lon: null
    }
  },
  created() {
    this.lat = this.$route.query.lat
    this.lon = this.$route.query.lon
  }
}
</script>

<style>
/* Add any CSS styling here */
</style>
