<script>


import ConfigParam from "../widgets/components/ConfigParam/ConfigParam.vue"
export default {
    name: "Configuration",
    data: function () {
            return {
		data: {},
	    };
	},
    methods: {
    	
	},
    components: {
		ConfigParam
    }
}
</script>

<template>
<div>

<ConfigParam name="qr_threshold" />
<ConfigParam name="expected_growth" />
<ConfigParam name="expected_risk" />
<ConfigParam name="growth_resolution" />
<ConfigParam name="call_payoff_threshold" />
<ConfigParam name="put_payoff_threshold" />

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
