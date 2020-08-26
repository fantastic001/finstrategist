<script>
import PortfolioService from "./service";

export default {
    name: "Portfolio",
    props: ["Portfolio"],
    data: function () {
        return {
            data: {},
        }
    },
    mounted: function () 
    {
        PortfolioService.get(this.Portfolio).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		PortfolioService.delete(this.Portfolio).then(response => this.data = {});
	}
	// add additional methods here
    }
}
</script>

<template>

<div class="portfolio-view">
<p>Cash {{ data.cash}}</p>

<table>

<tr>
<th>Ticker</th>
<th>Count</th>
</tr>

<tr v-for="asset in this.data.assets" :key="asset.ticker" :id="asset.ticker">
<td>{{ asset.ticker}}</td>
<td>{{ asset.count}}</td>
</tr>

</table>

</div>

</template>

<style scoped> 



</style>