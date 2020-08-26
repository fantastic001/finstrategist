<script>


import Portfolio from "../widgets/components/Portfolio/multi-Portfolio.vue"
export default {
    name: "Home",
    data: function () {
            return {
		data: {},
	    };
	},
    methods: {
    	
	},
    components: {
		Portfolio
    }
}
</script>

<template>
<div>
Home page
<Portfolio />
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
