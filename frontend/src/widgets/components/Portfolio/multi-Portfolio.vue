<script>
import PortfolioService from "./service";
import Portfolio from "./Portfolio.vue";


export default {
    name: "multi-Portfolio",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: []
        }
    },
    mounted: function () 
    {
        PortfolioService.list().then(response => this.items = response.data);
    },
    components: {
    	"Portfolio": Portfolio
    }
}
</script>

<template>
    <div class="multi-Portfolio"> 
      <Portfolio
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Portfolio="item.id"
          />
    </div>

</template>

<style scoped> 



</style>