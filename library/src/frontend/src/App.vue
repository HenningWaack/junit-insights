<!-- Top-Level Vue component for a report page -->
<template>
    <div id="app">
        <h1 style="font-size: 50px;">{{ this.report.reportTitle }}</h1>
        <button type="button" class="btn help-button" v-on:click="showHelp = true"><h2>?</h2></button>
        <HelpDialog v-if="showHelp" v-on:close="showHelp = false"></HelpDialog>
        <div class="overview-info">
            <OverviewChart :chartId="'overview'" :test-classes="report.testClasses"/>
            <GeneralInformation
                :spring-contexts-created="this.report.springContextsCreated"
                :tested-classes="this.numberOfTestedClasses"
                :tested-methods="this.numberOfTestedMethods"/>
        </div>
        <div>
            <h1 style="margin-top: 30px;">Time spent on individual test classes</h1>
            <!--
                These components emit events with functions for filtering and sorting
                The functions are then used by the filteredAndSorted computed value
            -->
            <TestClassFilter @changed="filterFunction = $event"/>
            <TestClassSorter @changed="sortFunction = $event"/>
        </div>
        <div id="class-charts">
            <class-chart v-for="testClass in filteredAndSorted"
                        :key="testClass.name"
                        :test-class="testClass"
                        :chartId="testClass.name"/>
        </div>
    </div>
</template>

<script>
    import TestClassSorter from "./components/TestClassSorter.vue";
    import TestClassFilter from "./components/TestClassFilter.vue";
    import OverviewChart from "./components/OverviewChart.vue";
    import ClassChart from "./components/ClassChart.vue";
    import GeneralInformation from "./components/GeneralInformation.vue";
    import HelpDialog from "./components/HelpDialog.vue"
    import PlotlyMixin from "./mixins/PlotlyMixin.js";

    export default {
        name: "app",
        props: ["report"],
        mixins: [PlotlyMixin],
        data() {
            return {
                sortFunction: () => -1,
                filterFunction: () => true,
                showHelp: false
            };
        },
        computed: {
            filteredAndSorted: function () {
                return this.report.testClasses
                    .filter(this.filterFunction)
                    .sort(this.sortFunction);
            },
            numberOfTestedClasses: function () {
                return this.report.testClasses.length;
            },
            numberOfTestedMethods: function () {
                return this.report.testClasses
                    .map(tc => tc.methods.length)
                    .reduce((a, b) => a + b, 0);
            }
        },
        mounted: function() {
            // Resize all plots after the whole page has loaded to avoid a bug:
            // https://github.com/adessoAG/junit-insights/issues/92
            this.resizeAllPlots(this.filteredAndSorted.map(el => el.name));
        },
        components: {
            TestClassSorter,
            TestClassFilter,
            OverviewChart,
            ClassChart,
            GeneralInformation,
            HelpDialog
        }
    };
</script>

<style scoped>
    #app {
        padding: 10px;
    }

    @media only screen and (min-width: 1200px){
        .overview-info {
            display: grid;
            grid-gap: 10px;
            grid-template-columns: 1fr 350px;
        }
    }

    @media only screen and (max-width: 1200px) {
        .overview-info > * {
            margin-top: 10px;
        }
    }

    .help-button {
        width: 50px;
        height: 50px;
        position: absolute;
        right: 10px;
        top: 10px;
        background-color: #FFFFFF;
        border: solid 1px lightgrey;
    }

    .help-button:hover, .help-button:focus, .help-button:active {
        background-color: #EEEEEE;
    }

    #class-charts > * {
        margin-top: 10px;
    }

</style>
