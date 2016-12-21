var webpack = require('webpack');
var path = require('path');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var HtmlWebpackPlugin = require('html-webpack-plugin');
var projectRoot = path.resolve(__dirname, './src')
var utils = require('./utils')

module.exports = {
    entry: {
        vendor: ['whatwg-fetch', 'vue'],
        index: ['./src/main.js']/*,
        login: ['./src/js/login/login.js']*/
    },
    output: {
        path: path.resolve(__dirname, '../static'),
        publicPath: '/',
        filename: 'js/site/[name]/[name].bundle.js'
    },
    module: {
        loaders: [
            {
                test: /\.vue$/,
                loader: 'vue'
            },
            {
                // edit this for additional asset file types
                test: /\.(png|jpg|gif|ico)$/,
                loader: 'url',
                query: {
                    // 把较小的图片转换成base64的字符串内嵌在生成的js文件里
                    limit: 10000,
                    // 路径要与当前配置文件下的publicPath相结合
                    name: 'images/[name].[ext]?[hash:7]'
                }
            },
            {
                test: /\.css$/,
                loader: ExtractTextPlugin.extract("css-loader")
            },
            {
                test: /\.(eot|woff|woff2|svg|ttf)([\?]?.*)$/,
                loader: 'url',
                query: {
                    limit: 10000,
                    // 路径和生产环境下的不同，要与修改后的publickPath相结合
                    name: 'css/fonts/[name].[ext]?[hash:7]',
                }
            },
            utils.styleLoaders({ sourceMap: true, extract: true})
        ]
    },
    vue: {
        loaders: utils.cssLoaders({ sourceMap: true }),
        postcss: [
            require('autoprefixer')({
                browsers: ['last 2 versions']
            })
        ]
    },
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.common.js',
            'src': path.resolve(__dirname, 'src'),
            'components': path.resolve(__dirname, 'src/js/components')
        }
    },
    plugins: [
        new ExtractTextPlugin("css/site/[name]/[name]-[id].css",{allChunks: true}),    //单独使用style标签加载css并设置其路径
        new HtmlWebpackPlugin({                        //根据模板插入css/js等生成最终HTML
            favicon: './src/img/icon/favicon.ico', //favicon路径
            filename: '../templates/index.ftl',    //生成的html存放路径，相对于 path
            template: './src/template/index.html',    //html模板路径
            chunks: ['vendor','site'],
            inject: true,    //允许插件修改哪些内容，包括head与body
            hash: true,    //为静态资源生成hash值
            minify: {    //压缩HTML文件
                removeComments: true,    //移除HTML中的注释
                collapseWhitespace: false    //删除空白符与换行符
            }
        }),
        new HtmlWebpackPlugin({                        //根据模板插入css/js等生成最终HTML
            favicon: './src/img/icon/favicon.ico', //favicon路径
            filename: '../templates/login/login.ftl',    //生成的html存放路径，相对于 path
            template: './src/template/login/login.html',    //html模板路径
            inject: true,    //允许插件修改哪些内容，包括head与body
            chunks: ['vendor','login'],
            hash: true,    //为静态资源生成hash值
            minify: {    //压缩HTML文件
                removeComments: true,    //移除HTML中的注释
                collapseWhitespace: false    //删除空白符与换行符
            }
        }),
        new webpack.optimize.CommonsChunkPlugin({
            name:'vendor',
            filename:'js/commons.js'
        })
    ]
};

if (process.env.NODE_ENV === 'production') {
    module.exports.plugins = [
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false
            }
        }),
        new webpack.optimize.OccurenceOrderPlugin()
    ]
} else {
    module.exports.devtool = '#source-map'
}
