<script>


import StockForm from "../widgets/components/StockForm/StockForm.vue"
export default {
    name: "SubmitStock",
    data: function () {
            return {
		data: {},
	    };
	},
    methods: {
    	
	},
    components: {
		StockForm
    }
}
</script>

<template>
<div>
Add stock information
<StockForm />
</div>
</template>

<style scoped> 

.search-toggle {
	margin: 10px;
}

.search-part {
	background-color: #ddd;
	padding: 10px;
	margin: 10px;
}

</style>
