<script>


import CIForm from "../widgets/components/CompanyInfo/CompanyInfo.vue"
export default {
    name: "SubmitCompanyInfo",
    data: function () {
            return {
		data: {},
	    };
	},
    methods: {
    	
	},
    components: {
		CIForm
    }
}
</script>

<template>
<div>
Add company information
<CIForm />
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
