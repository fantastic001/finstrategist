<script>
import ConfigParamService from "./service";

export default {
    name: "ConfigParam",
	props: ["name"],
    data: function () {
        return {
            data: 0.0

        };
    },
	mounted: function() {
		ConfigParamService.get(this.name).then(response => {
			this.data = response.data;
		});
	},
    methods: {
    	submit: function() 
	{
		ConfigParamService.submit(this.name, this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	}
    }
}
</script>

<template>
    <div class="form-ConfigParam"> 
        <div class="success-box" v-if="success">Property set</div>
	<div v-if="!success"> 
		
		
		<p>
		{{ name }}
		<input type="number" step="any" v-model="data" />
		<button  v-on:click="submit">Submit</button>
		</p>
		

	</div>
    </div>

</template>

<style scoped> 

.form-ConfigParam {

}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>