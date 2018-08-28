#!/usr/bin/env bash

####### 数据库操作
function exe_sql(){
host='127.0.0.1'
port='3306'
user='root'
pwd='123456'
db_name='demo_new'

echo "数据库操作..."
for((i=1001; i<=1002; i++));
do
echo 'update user'$i
data=`/usr/local/mysql/bin/mysql -h$host -P$port -u$user -p$pwd $db_name -e "select * from user ;"`
## 用变量暂存数据会合并换行符
echo $data >> data.log

pwd=`pwd`
echo "当前目录"$pwd

done
}




#rm -rf interResult
#rm -rf interFinalResult
#dir="/home/w/www/"
# for file in `ls $dir`
# do
# if [ -d $dir"/"$file ]
# then
# echo '目录===='$dir"/"$file
# if [ ! -f $dir"/"$file"/logs/dubbo-access-consumer.log" ]; then
# echo $dir"/"$file'====没有日志!';
# else
# zcat $dir"/"$file/logs/dubbo-access-consumer.*.log.gz | awk -F' ' '{print NF}' | sort | uniq | more
# cat $dir"/"$file/logs/dubbo-access-consumer.log | awk -F' ' '{print NF}' | sort | uniq | more
# zcat $dir"/"$file/logs/dubbo-access-consumer.*.log.gz | awk -F' ' '{print $17$18}' | sort | uniq >> interResult
# cat $dir"/"$file/logs/dubbo-access-consumer.log | awk -F' ' '{print $17$18}' | sort | uniq >> interResult
# cat interResult | sort | uniq >> interFinalResult
# fi
# else
# echo $dir"/"$file'====不是目录!'
# fi
# done
#
#echo '######################最终结果###################################'
#cat interFinalResult

echo "......"
exe_sql

#cd ~/code/sh_dir
#
#cur_dir=`pwd`
#echo "当前目录 "$cur_dir
#
#for file in `ls $cur_dir`
#do
#echo "当前文件/目录 "$file
#
#if [ -f $file ]
#then
# echo $file"是文件"
#else
#echo $file"是目录"
#fi
#
#done